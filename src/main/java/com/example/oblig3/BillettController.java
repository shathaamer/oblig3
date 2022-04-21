package com.example.oblig3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class BillettController {
    @Autowired
   private BillettRepository rep;

    @PostMapping("/lagring")
    public void lagreBillett(Billett innbillett){
        rep.lagreBilletter(innbillett);
    }
    @GetMapping("/hentAlle")
    public List<Billett> hentBillettene(){
       return rep.hentBilletter();
    }
    @GetMapping("/slettAlle")
    public void slett(){
        rep.slettBilletter();
    }
}
