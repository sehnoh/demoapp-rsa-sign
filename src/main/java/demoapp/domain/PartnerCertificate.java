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

    @Column(name = "cert_file_name")
    private String certFileName;

    @Column(name = "public_key")
    private String publicKey;

    @Column(name = "valid_from_date")
    private Date validFromDate;

    @Column(name = "valid_until_date")
    private Date validUntilDate;

}
