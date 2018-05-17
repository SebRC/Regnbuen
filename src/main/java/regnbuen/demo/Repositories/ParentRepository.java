package regnbuen.demo.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import regnbuen.demo.Models.ParentModel;


import java.util.ArrayList;
import java.util.List;

@Repository
public class ParentRepository
{
    @Autowired
    private JdbcTemplate jdbc;

    public ParentModel get(int id)
    {

        String sql = "SELECT * Parent where parent_id = " + id;

        SqlRowSet rs = jdbc.queryForRowSet(sql);

        rs.next();

        ParentModel parent =
                new ParentModel(rs.getInt("parent_id"), rs.getString("parent_first_name"), rs.getString("parent_last_name"),
                        rs.getString("parent_phone"), rs.getString("parent_workplace_phone"));
        return parent;
    }

    public List<ParentModel> getList()
    {
        List<ParentModel> parentList = new ArrayList<>();

        String sql = "SELECT * FROM Parent";

        SqlRowSet rs = jdbc.queryForRowSet(sql);
        while(rs.next())
        {
            parentList.add(new ParentModel
                    (rs.getInt("parent_id"), rs.getString("parent_first_name"), rs.getString("parent_last_name"),
                    rs.getString("parent_phone"), rs.getString("parent_workplace_phone")));
        }

        return parentList;
    }

    public void parentCreate(ParentModel parentModel)
    {

        String sqlCreate = "insert into Parent(parent_first_name, parent_last_name, parent_phone, parent_workplace_phone)" +
                " values('" + parentModel.getParent_first_name() + "', '" +
                parentModel.getParent_last_name() + "', '" +
                parentModel.getParent_phone() + "', '" +
                parentModel.getParent_workplace_phone() + "')";

        jdbc.update(sqlCreate);
    }

}
