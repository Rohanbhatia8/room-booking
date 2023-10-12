package com.roombooking;

public class Organization {
    private Long orgId;
    private String orgName;
    private String contactEmail;
    private String contactPhone;

    // Constructors
    public Organization() {
    }

    public Organization(String orgName, String contactEmail, String contactPhone) {
        this.orgName = orgName;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
    }

    // Getter and Setter methods
    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    // Override toString() method for easy debugging
    @Override
    public String toString() {
        return "Organization{" +
                "orgId=" + orgId +
                ", orgName='" + orgName + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                '}';
    }
}

