package regnbuen.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import regnbuen.demo.Models.*;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ViewFactory
{

    @Autowired
    private JdbcTemplate jdbc = new JdbcTemplate();

    public List<ViewModel> createViewModels()
    {
        List<ViewModel> viewModels = new ArrayList<>();

        String sqlQuery = "SELECT COUNT(*) FROM Member AS members;";

        SqlRowSet firstRs = jdbc.queryForRowSet(sqlQuery);

        System.out.println(firstRs.next());

        int numOfMembers = firstRs.getInt(1);

        sqlQuery = "SELECT * FROM Member AS m " +
                "INNER JOIN Doctor AS d ON m.doctor_id = d.doctor_id " +
                "INNER JOIN Grade AS g ON m.grade_id = g.grade_id " +
                "INNER JOIN School AS s ON m.school_id = s.school_id;";

        System.out.println("før sql");
        SqlRowSet rs = jdbc.queryForRowSet(sqlQuery);
        System.out.println("efter sql");

        while(rs.next())
        {
            System.out.println("start af loop");
            ViewModel viewModel = new ViewModel();
            System.out.println("viewmodel oprettet");

            MemberModel memberModel = new MemberModel(rs.getInt(1), rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getString(5), rs.getString(6),
                    rs.getDate(7), rs.getDate(8), rs.getString(9),
                    rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13),
                    rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17),
                    rs.getInt(18), rs.getInt(19), rs.getInt(20), rs.getString(21));

            System.out.println("membermodel oprettet");

            viewModel.setMemberModel(memberModel);
            System.out.println("membermodel added");

            GradeModel gradeModel = new GradeModel(rs.getInt("grade_id"), rs.getString("grade_name"));

            System.out.println("grademodel oprettet");

            viewModel.setGradeModel(gradeModel);

            System.out.println("grademodel added");

            DoctorModel doctorModel = new DoctorModel(rs.getInt("doctor_id"), rs.getString("doctor_phone"),
                    rs.getString("doctor_first_name"), rs.getString("doctor_last_name"));

            System.out.println("doctormodel oprettet");

            viewModel.setDoctorModel(doctorModel);

            System.out.println("doctormodel added");

            SchoolModel schoolModel = new SchoolModel(rs.getInt("school_id"), rs.getString("school_name"), rs.getString("school_address"),
                    rs.getString("school_phone"));

            System.out.println("schoolmodel oprettet");

            viewModel.setSchoolModel(schoolModel);

            System.out.println("schoolmodel added");

            viewModels.add(viewModel);
            System.out.println("viewmodel added");
        }
        return viewModels;
    }
}
