package demoapp.domain;

import lombok.Data;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "partner_certificate")
@Data
public class PartnerCertificate extends AbstractEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "partner_id", nullable = false)
    private Partner partner;

    @Lob
    @Column(name = "certificate", length = 100000)
    private byte[] certificate;

    @Column(name = "version")
    private String version;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "subject")
    private String subject;

    @Column(name = "issuer")
    private String issuer;

    @Column(name = "valid_from")
    private Date validFrom;

    @Column(name = "valid_until")
    private Date validUntil;

    @Column(name = "public_key")
    private String publicKey;

    @Column(name = "sig_algorithm")
    private String sigAlgorithm;
}
