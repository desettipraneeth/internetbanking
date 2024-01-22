package com.os.service.impl;

import com.os.dto.OrganizationDto;
import com.os.entity.Organization;
import com.os.mapper.OrganizationMapper;
import com.os.repository.OrganizationRepo;
import com.os.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationRepo or;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {

        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);

        Organization savedOrganization = or.save(organization);

        return OrganizationMapper.mapToOrganizationDto(savedOrganization);

    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization = or.findByOrganizationCode(organizationCode);
        return OrganizationMapper.mapToOrganizationDto(organization);
    }
}
