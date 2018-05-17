package regnbuen.demo.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import regnbuen.demo.Models.DoctorModel;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DoctorRepository
{
    @Autowired
    private JdbcTemplate jdbc;

    public DoctorModel get(int id)
    {
        String sql = "SELECT * Doctor where doctor_id = " + id;

        SqlRowSet rs = jdbc.queryForRowSet(sql);

        rs.next();

        DoctorModel doctor =
                new DoctorModel(rs.getInt("doctor_id"), rs.getString("doctor_phone"), rs.getString("doctor_first_name"),
                        rs.getString("doctor_last_name"));
        return doctor;
    }

    public List<DoctorModel> getList()
    {
        List<DoctorModel> doctorList = new ArrayList<>();
        String sqlQuery = "SELECT * FROM Doctor";

        SqlRowSet rs = jdbc.queryForRowSet(sqlQuery);

        while(rs.next())
        {
            doctorList.add(new DoctorModel(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getString(4)));
        }
        return doctorList;
    }

    public void doctorCreate(DoctorModel doctorModel)
    {

        String sqlCreate = "insert into Doctor(doctor_phone, doctor_first_name, doctor_last_name)" +
                " values('" + doctorModel.getDoctor_phone() + "', '" +
                doctorModel.getDoctor_first_name() + "', '" +
                doctorModel.getDoctor_last_name() + "')";


        jdbc.update(sqlCreate);
    }
}