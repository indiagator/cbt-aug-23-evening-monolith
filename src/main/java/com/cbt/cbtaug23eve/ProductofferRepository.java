package com.cbt.cbtaug23eve;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductofferRepository extends JpaRepository<Productoffer, String>
{
    @Query(value = "select * from productoffers p where p.sellername=?1",nativeQuery = true)
    public List<Productoffer> findBySellername(String sellername);

}