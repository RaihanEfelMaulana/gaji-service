/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raihanefelmaulana.gaji.service.Service;

import com.raihanefelmaulana.gaji.service.Entity.Gaji;
import com.raihanefelmaulana.gaji.service.Repository.GajiRepository;
import com.raihanefelmaulana.gaji.service.Vo.Golongan;
import com.raihanefelmaulana.gaji.service.Vo.Karyawan;
import com.raihanefelmaulana.gaji.service.Vo.ResponseTemplateVo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author hp
 */
@Service

public class GajiService {
    @Autowired
    private SimpleDateFormat simpleDateFormat;
    
    @Autowired
    private GajiRepository gajiRepository;
    
    @Autowired
    private RestTemplate restTemplate;
    
    public Gaji saveGaji(Gaji gaji){
        String tglSekarang = simpleDateFormat.format(new Date());   
        Golongan golongan = restTemplate.getForObject("http://localhost:8081/golongan/" 
                + gaji.getGolonganId(), Golongan.class);
        long totalGaji = golongan.getGajiPokok() + gaji.getTunjanganAnak() + gaji.getTunjanganSuamiIstri();
        gaji.setTotalGaji(totalGaji);
        gaji.setGajiTanggal(tglSekarang);
        return gajiRepository.save(gaji);
    }
    
     public ResponseTemplateVo getGaji(Long gajiId){
        ResponseTemplateVo vo = new ResponseTemplateVo();
        Gaji gaji = gajiRepository.findByGajiId(gajiId);
        Karyawan karyawan = restTemplate.getForObject("http://localhost:8080/karyawan/" 
              + gaji.getKaryawanId(), Karyawan.class);
        Golongan golongan = restTemplate.getForObject("http://localhost:8081/golongan/" 
                + gaji.getGolonganId(), Golongan.class);
        vo.setGaji(gaji);
        vo.setKaryawan(karyawan);
        vo.setGolongan(golongan);
        return vo;
    }
}
