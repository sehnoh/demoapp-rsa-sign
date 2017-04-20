package demoapp.service;

import demoapp.domain.Partner;
import demoapp.domain.PartnerCertificate;
import demoapp.repository.PartnerCertificateRepository;
import demoapp.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartnerService {

    @Autowired
    private PartnerRepository partnerRepository;

    @Autowired
    private PartnerCertificateRepository partnerCertificateRepository;

    public Partner getPartner(Long partnerId) {
        return partnerRepository.findOne(partnerId);
    }

    public PartnerCertificate getLastValidPartnerCertificate(Long partnerId) {
        return partnerCertificateRepository.findOneByPartnerIdAndValidDate(partnerId);
    }
}
