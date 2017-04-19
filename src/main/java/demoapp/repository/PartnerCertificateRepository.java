package demoapp.repository;

import demoapp.domain.PartnerCertificate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerCertificateRepository extends JpaRepository<PartnerCertificate, Long> {

}
