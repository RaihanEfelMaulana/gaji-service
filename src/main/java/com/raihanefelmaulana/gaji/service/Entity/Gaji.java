/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raihanefelmaulana.gaji.service.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author hp
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Gaji {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private Long gajiId;
    private Long karyawanId;
    private Long golonganId;
    private String gajiTanggal;
    private Long jumlahanak;
    private Long tunjanganAnak;
    private Long tunjanganSuamiIstri;
    private double totalGaji;
}
