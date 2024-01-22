package com.os.repository;

import com.os.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepo extends JpaRepository<Organization, Long> {
    Organization findByOrganizationCode(String organizationCode);
}
