package com.example.computerrepaircenter.service;

import com.example.computerrepaircenter.dto.ComponentDto;
import com.example.computerrepaircenter.dto.ComponentResponseDto;
import com.example.computerrepaircenter.mapper.ComponentMapper;
import com.example.computerrepaircenter.model.Component;
import com.example.computerrepaircenter.repository.ComponentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ComponentServiceImpl implements ComponentService {
    private final ComponentRepository componentRepository;
    private final ComponentMapper componentMapper;

    @Override
    public ComponentResponseDto saveComponent(ComponentDto componentDto) {
        Component component = componentMapper.toModel(componentDto);

        return componentMapper.toDto(componentRepository.save(component));
    }

    @Override
    public void deleteComponentById(Long id) {
        if (componentRepository.existsById(id)) {
            componentRepository.deleteById(id);
        }
    }

    @Override
    public ComponentResponseDto updateComponent(Long id, ComponentDto componentDto) {
        Component component = componentMapper.toModel(componentDto);
        component.setId(id);
        return componentMapper.toDto(componentRepository.save(component));
    }

    @Override
    public ComponentResponseDto getComponentById(Long id) {
        Component component = componentRepository.findById(id).orElseThrow(()
                -> new RuntimeException("cannot find component by id: " + id));

        return componentMapper.toDto(component);
    }

    @Override
    public Page<ComponentResponseDto> getAllComponents(Pageable pageable) {
        return componentRepository.findAll(pageable).map(componentMapper::toDto);
    }
}
