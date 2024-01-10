package com.black.demo.Controller;

import com.black.demo.Service.BlackService;
import com.black.demo.Service.IMPL.BlackServiceIMPL;
import com.black.demo.Service.IMPL.OmpaWeight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BlackClass {

    @Autowired
    BlackServiceIMPL blackService;
    @Autowired
    OmpaWeight ompaWeight;

    @GetMapping("/ifkid")
    public String ifKid(@RequestParam int age, boolean ompa) {
        if(ompa) {
            return ompaWeight.ifKids(age);
        }
        return blackService.ifKids(age);
    }

    @GetMapping("/namer")
    public String namer(@RequestParam String name) {
        return "This is the returned name "+name;
    }
}
//\https://open.spotify.com/artist/5EEuae5uigQnwgYCl0s8EF?si=O959qTMbQiO53-HgLcsIcA