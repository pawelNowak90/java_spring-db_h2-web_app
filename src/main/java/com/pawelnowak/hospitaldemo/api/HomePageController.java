package com.pawelnowak.hospitaldemo.api;

import com.pawelnowak.hospitaldemo.db.repository.DoctorRepository;
import com.pawelnowak.hospitaldemo.db.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    private final DoctorRepository doctorRepository;
    private final HospitalRepository hospitalRepository;

    @Autowired
    public HomePageController(DoctorRepository doctorRepository, HospitalRepository hospitalRepository) {
        this.doctorRepository = doctorRepository;
        this.hospitalRepository = hospitalRepository;
    }

    @GetMapping(value = {"/index", "/"})
    public String showHomePage(Model model) {
        model.addAttribute("doctors", doctorRepository.findAll());
        model.addAttribute("hospitals", hospitalRepository.findAll());
        return "index";
    }
}