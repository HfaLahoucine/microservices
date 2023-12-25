package com.ecommerce.microserviceclient.proxies;


import com.ecommerce.microserviceclient.beans.VoitureBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@FeignClient(name = "microservice-produits", url = "produits:9001")
public interface MicroserviceProduitsProxy {


    @GetMapping(value = "/voitures")
    List<VoitureBean> getAllVoitures();

    @GetMapping( value = "/voitures/{id}")
    VoitureBean getVoitureById(@PathVariable("id") int id);

    @PostMapping(value = "/voitures")
    VoitureBean createVoiture(@Valid @RequestBody VoitureBean voiture);
}
