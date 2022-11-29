/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raihanefelmaulana.gaji.service.Controller;

import com.raihanefelmaulana.gaji.service.Entity.Gaji;
import com.raihanefelmaulana.gaji.service.Service.GajiService;
import com.raihanefelmaulana.gaji.service.Vo.ResponseTemplateVo;
import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hp
 */
@RestController
@RequestMapping("/gaji")

public class GajiController {
    @Autowired
    private GajiService gajiService;
    
    @PostMapping("/")
    public Gaji savegaji(@RequestBody Gaji gaji) throws ParseException{
        return gajiService.saveGaji(gaji);
    }
    
    @GetMapping("{id}")
    public ResponseTemplateVo getGaji(@PathVariable("id") Long gajiId){
     return gajiService.getGaji(gajiId);
    }
}
