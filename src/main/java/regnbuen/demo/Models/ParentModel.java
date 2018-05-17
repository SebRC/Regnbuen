package regnbuen.demo.Models;

public class ParentModel
{

    private int parent_id;
    private String parent_first_name;
    private String parent_last_name;
    private String parent_phone;
    private String parent_workplace_phone;

    public ParentModel()
    {

    }

    public ParentModel(int parent_id, String parent_first_name, String parent_last_name, String parent_phone, String parent_workplace_phone)
    {
        this.parent_id = parent_id;
        this.parent_first_name = parent_first_name;
        this.parent_last_name = parent_last_name;
        this.parent_phone = parent_phone;
        this.parent_workplace_phone = parent_workplace_phone;
    }

    public int getParent_id()
    {
        return parent_id;
    }

    public void setParent_id(int parent_id)
    {
        this.parent_id = parent_id;
    }

    public String getParent_first_name()
    {
        return parent_first_name;
    }

    public void setParent_first_name(String parent_first_name)
    {
        this.parent_first_name = parent_first_name;
    }

    public String getParent_last_name()
    {
        return parent_last_name;
    }

    public void setParent_last_name(String parent_last_name)
    {
        this.parent_last_name = parent_last_name;
    }

    public String getParent_phone()
    {
        return parent_phone;
    }

    public void setParent_phone(String parent_phone)
    {
        this.parent_phone = parent_phone;
    }

    public String getParent_workplace_phone()
    {
        return parent_workplace_phone;
    }

    public void setParent_workplace_phone(String parent_workplace_phone)
    {
        this.parent_workplace_phone = parent_workplace_phone;
    }
}
