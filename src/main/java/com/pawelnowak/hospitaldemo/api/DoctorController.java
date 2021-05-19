package com.pawelnowak.hospitaldemo.api;

import com.pawelnowak.hospitaldemo.db.Doctor;
import com.pawelnowak.hospitaldemo.db.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class DoctorController {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @GetMapping("/adddoctor")
    public String showSignUpForm(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "add-doctor";
    }

    @PostMapping("/savedoctor")
    public String addDoctor(@Valid Doctor doctor, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-doctor";
        }

        doctorRepository.save(doctor);
        return "redirect:/index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid doctor Id:" + id));
        model.addAttribute("doctor", doctor);

        return "edit-doctor";
    }

    @PostMapping("/update/{id}")
    public String updateDoctor(@PathVariable("id") long id, @Valid Doctor doctor, BindingResult result, Model model) {
        if (result.hasErrors()) {
            doctor.setId(id);
            return "edit-doctor";
        }

        doctorRepository.save(doctor);

        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteDoctor(@PathVariable("id") long id, Model model) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid doctor Id:" + id));
        doctorRepository.delete(doctor);

        return "redirect:/index";
    }
}