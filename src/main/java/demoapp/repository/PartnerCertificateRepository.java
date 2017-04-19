package demoapp.repository;

import demoapp.domain.PartnerCertificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PartnerCertificateRepository extends JpaRepository<PartnerCertificate, Long> {

    @Query("select a from PartnerCertificate a "
            + "where a.partner.id like ?1 and a.validFrom <= CURRENT_DATE and a.validUntil >= CURRENT_DATE "
            + "order by a.id desc")
    PartnerCertificate findOneByPartnerIdAndValidFromLessThanEqualAndValidUntilGreaterThanEqual(Long partnerId);

}
