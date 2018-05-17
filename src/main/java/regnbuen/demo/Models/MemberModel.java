package regnbuen.demo.Models;

import java.sql.Date;

public class MemberModel
{
    private int member_id;
    private String first_name;
    private String last_name;
    private String gender;
    private String address;
    private String member_phone;
    private Date enrollment_date;
    private Date date_of_resignation;

    private String drive_permission;
    private String has_allergies;
    private String member_details;

    private String parent1_name;
    private String parent1_phone;
    private String parent1_workplace_phone;

    private String parent2_name;
    private String parent2_phone;
    private String parent2_workplace_phone;

    private int school_id;
    private int grade_id;
    private int doctor_id;

    private String member_home_phone;

    public MemberModel()
    {

    }

    public MemberModel(int member_id, String first_name, String last_name, String gender, String address, String member_phone, Date enrollment_date, Date date_of_resignation, String drive_permission, String has_allergies, String member_details, String parent1_name, String parent1_phone, String parent1_workplace_phone, String parent2_name, String parent2_phone, String parent2_workplace_phone, int school_id, int grade_id, int doctor_id, String member_home_phone)
    {
        this.member_id = member_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.address = address;
        this.member_phone = member_phone;
        this.enrollment_date = enrollment_date;
        this.date_of_resignation = date_of_resignation;
        this.drive_permission = drive_permission;
        this.has_allergies = has_allergies;
        this.member_details = member_details;
        this.parent1_name = parent1_name;
        this.parent1_phone = parent1_phone;
        this.parent1_workplace_phone = parent1_workplace_phone;
        this.parent2_name = parent2_name;
        this.parent2_phone = parent2_phone;
        this.parent2_workplace_phone = parent2_workplace_phone;
        this.school_id = school_id;
        this.grade_id = grade_id;
        this.doctor_id = doctor_id;
        this.member_home_phone = member_home_phone;
    }

    public String getMember_home_phone()
    {
        return member_home_phone;
    }

    public void setMember_home_phone(String member_home_phone)
    {
        this.member_home_phone = member_home_phone;
    }

    public int getMember_id()
    {
        return member_id;
    }

    public void setMember_id(int member_id)
    {
        this.member_id = member_id;
    }

    public String getFirst_name()
    {
        return first_name;
    }

    public void setFirst_name(String first_name)
    {
        this.first_name = first_name;
    }

    public String getLast_name()
    {
        return last_name;
    }

    public void setLast_name(String last_name)
    {
        this.last_name = last_name;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getMember_phone()
    {
        return member_phone;
    }

    public void setMember_phone(String member_phone)
    {
        this.member_phone = member_phone;
    }

    public Date getEnrollment_date()
    {
        return enrollment_date;
    }

    public void setEnrollment_date(Date enrollment_date)
    {
        this.enrollment_date = enrollment_date;
    }

    public Date getDate_of_resignation()
    {
        return date_of_resignation;
    }

    public void setDate_of_resignation(Date date_of_resignation)
    {
        this.date_of_resignation = date_of_resignation;
    }

    public String getDrive_permission()
    {
        return drive_permission;
    }

    public void setDrive_permission(String drive_permission)
    {
        this.drive_permission = drive_permission;
    }

    public String getHas_allergies()
    {
        return has_allergies;
    }

    public void setHas_allergies(String has_allergies)
    {
        this.has_allergies = has_allergies;
    }

    public String getMember_details()
    {
        return member_details;
    }

    public void setMember_details(String member_details)
    {
        this.member_details = member_details;
    }

    public String getParent1_name()
    {
        return parent1_name;
    }

    public void setParent1_name(String parent1_name)
    {
        this.parent1_name = parent1_name;
    }

    public String getParent1_phone()
    {
        return parent1_phone;
    }

    public void setParent1_phone(String parent1_phone)
    {
        this.parent1_phone = parent1_phone;
    }

    public String getParent1_workplace_phone()
    {
        return parent1_workplace_phone;
    }

    public void setParent1_workplace_phone(String parent1_workplace_phone)
    {
        this.parent1_workplace_phone = parent1_workplace_phone;
    }

    public String getParent2_name()
    {
        return parent2_name;
    }

    public void setParent2_name(String parent2_name)
    {
        this.parent2_name = parent2_name;
    }

    public String getParent2_phone()
    {
        return parent2_phone;
    }

    public void setParent2_phone(String parent2_phone)
    {
        this.parent2_phone = parent2_phone;
    }

    public String getParent2_workplace_phone()
    {
        return parent2_workplace_phone;
    }

    public void setParent2_workplace_phone(String parent2_workplace_phone)
    {
        this.parent2_workplace_phone = parent2_workplace_phone;
    }

    public int getSchool_id()
    {
        return school_id;
    }

    public void setSchool_id(int school_id)
    {
        this.school_id = school_id;
    }

    public int getGrade_id()
    {
        return grade_id;
    }

    public void setGrade_id(int grade_id)
    {
        this.grade_id = grade_id;
    }

    public int getDoctor_id()
    {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id)
    {
        this.doctor_id = doctor_id;
    }
}
