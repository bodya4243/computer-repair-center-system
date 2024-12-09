package com.example.computerrepaircenter.service;

import com.example.computerrepaircenter.dto.ComponentDto;
import com.example.computerrepaircenter.dto.ComponentResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ComponentService {
    ComponentResponseDto saveComponent(ComponentDto componentDto);

    void deleteComponentById(Long id);

    ComponentResponseDto updateComponent(Long id, ComponentDto componentDto);

    ComponentResponseDto getComponentById(Long id);

    Page<ComponentResponseDto> getAllComponents(Pageable pageable);
}
