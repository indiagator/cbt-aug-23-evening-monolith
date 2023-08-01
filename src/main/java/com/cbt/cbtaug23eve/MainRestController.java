package com.cbt.cbtaug23eve;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1")
public class MainRestController
{

    @Autowired
    CredentialRepository credentialRepository;

    @Autowired
    UserdetailRepository userdetailRepository;

    @Autowired
    UsertypelinkRepository usertypelinkRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductofferRepository productofferRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderstatusRepository orderstatusRepository;

    @Autowired
    ProductOfferService productOfferService;

    @GetMapping("/")
    public String greet()
    {
        return "Welcome to CBT_APP";
    }

    @PostMapping("signup")
    public ResponseEntity<String> signup(@RequestBody Credential credential)
    {
        credentialRepository.save(credential);
        return new ResponseEntity<>("New Signup Successful", HttpStatus.OK);
    }

    @PostMapping("save/user/detail")
    public ResponseEntity<Userdetail> saveUserDetail(@RequestBody Userdetail userdetail)
    {
        userdetailRepository.save(userdetail);
        return new ResponseEntity<>(userdetail,HttpStatus.OK);
    }

    @PostMapping("save/user/type")
    public ResponseEntity<Usertypelink> saveUserTypeLink(@RequestBody Usertypelink usertypelink)
    {
        usertypelink.setLinkid(String.valueOf((int)(Math.random()*100000)));
        usertypelinkRepository.save(usertypelink);

        return new ResponseEntity<>(usertypelink,HttpStatus.OK);
    }

    @GetMapping("get/product/all")
    public List<Product> getAllProducts()
    {
        return productRepository.findAll();
    }


    @PostMapping("save/product/offer")
    public ResponseEntity<Productoffer> saveProductOffer(@RequestBody Productoffer productoffer)
    {
        productoffer.setId(String.valueOf((int)(Math.random()*100000)));
        productofferRepository.save(productoffer);
        return new ResponseEntity<>(productoffer,HttpStatus.OK);
    }

    @PostMapping("save/order")
    public ResponseEntity<Order> saveOrder(@RequestBody Order order)
    {
        order.setOrderid(String.valueOf((int)(Math.random()*100000)));
        orderRepository.save(order);

        Orderstatus orderstatus = new Orderstatus();
        orderstatus.setId(String.valueOf((int)(Math.random()*100000)));
        orderstatus.setOrderid(order.getOrderid());
        orderstatus.setStatus("OPEN");

        orderstatusRepository.save(orderstatus);

        return new ResponseEntity<>(order,HttpStatus.OK);
    }

    @GetMapping("get/product/offer/all")
    public List<FullProductOffer> getAllOffers()
    {
        return productofferRepository.findAll().stream().map(productoffer ->
                                        {
                                            return productOfferService.composeFullOffer(productoffer.getId());
                                        }).collect(Collectors.toList());
    }

    @GetMapping("get/product/offer/all/sellerwise/{sellername}")
    public List<FullProductOffer> getProductOffersSellerwise(@PathVariable("sellername") String sellername)
    {

        return productofferRepository.findBySellername(sellername).stream().map(productoffer ->
        {
            return productOfferService.composeFullOffer(productoffer.getId());
        }).collect(Collectors.toList());

    }



}
