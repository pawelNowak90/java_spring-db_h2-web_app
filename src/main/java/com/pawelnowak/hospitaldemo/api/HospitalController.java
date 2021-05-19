package com.pawelnowak.hospitaldemo.api;

import com.pawelnowak.hospitaldemo.db.Hospital;
import com.pawelnowak.hospitaldemo.db.repository.DoctorRepository;
import com.pawelnowak.hospitaldemo.db.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class HospitalController {

    private final DoctorRepository doctorRepository;
    private final HospitalRepository hospitalRepository;

    @Autowired
    public HospitalController(DoctorRepository doctorRepository, HospitalRepository hospitalRepository) {
        this.doctorRepository = doctorRepository;
        this.hospitalRepository = hospitalRepository;
    }

    @GetMapping("hospital/add")
    public String showSignUpForm(Model model) {
        model.addAttribute("hospital", new Hospital());
        return "add-hospital";
    }

    @PostMapping("hospital/save")
    public String addHospital(@Valid Hospital hospital, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-hospital";
        }

        hospitalRepository.save(hospital);
        return "redirect:/index";
    }

    @GetMapping("hospital/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Hospital hospital = hospitalRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid hospital Id:" + id));
        model.addAttribute("hospital", hospital);

        return "edit-hospital";
    }

    @PostMapping("hospital/update/{id}")
    public String updateHospital(@PathVariable("id") long id, @Valid Hospital hospital, BindingResult result, Model model) {
        if (result.hasErrors()) {
            hospital.setId(id);
            return "edit-hospital";
        }

        hospitalRepository.save(hospital);
        return "redirect:/index";
    }

    @GetMapping("hospital/delete/{id}")
    public String deleteHospital(@PathVariable("id") long id, Model model) {
        Hospital hospital = hospitalRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid hospital Id:" + id));
        hospitalRepository.delete(hospital);

        return "redirect:/index";
    }
}