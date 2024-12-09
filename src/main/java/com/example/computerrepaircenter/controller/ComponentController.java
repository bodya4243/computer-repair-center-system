package com.example.computerrepaircenter.controller;

import com.example.computerrepaircenter.dto.ComponentDto;
import com.example.computerrepaircenter.dto.ComponentResponseDto;
import com.example.computerrepaircenter.service.ComponentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping(value = "/components")
@RestController
public class ComponentController {
    private final ComponentService componentService;

    @CrossOrigin(origins = "http://localhost:5174")
    @PostMapping
    ComponentResponseDto saveComponent(@RequestBody ComponentDto componentDto) {
        return componentService.saveComponent(componentDto);
    }

    @GetMapping("/{id}")
    ComponentResponseDto getComponent(@PathVariable Long id) {
        return componentService.getComponentById(id);
    }

    @GetMapping
    Page<ComponentResponseDto> getAllComponents(Pageable pageable) {
        return componentService.getAllComponents(pageable);
    }

    @PutMapping("/{id}")
    ComponentResponseDto updateComponent(@PathVariable Long id,
                                 @RequestBody ComponentDto componentDto) {
        return componentService.updateComponent(id, componentDto);
    }

    @DeleteMapping("/{id}")
    void deleteComponent(@PathVariable Long id) {
        componentService.deleteComponentById(id);
    }
}
