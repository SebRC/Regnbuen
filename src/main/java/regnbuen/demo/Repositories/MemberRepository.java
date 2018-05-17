package regnbuen.demo.Repositories;

import org.springframework.jdbc.support.rowset.SqlRowSet;
import regnbuen.demo.Interfaces.RepositoryInterface;
import regnbuen.demo.Models.MemberModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import regnbuen.demo.Models.SchoolModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Repository
public class MemberRepository implements RepositoryInterface
{
    @Autowired
    private JdbcTemplate jdbc;

    public List<MemberModel> getForside()
    {

        List<MemberModel> members = new ArrayList<>();

        String sql = "SELECT * FROM Member " +
                "join Grade on Member.grade_id = Grade.grade_id " +
                "join School on Member.school_id = School.school_id " +
                "order by enrollment_date desc";
        SqlRowSet rs = jdbc.queryForRowSet(sql);

        while(rs.next())
        {

            members.add(new MemberModel(rs.getInt(1), rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getString(5), rs.getString(6),
                    rs.getDate(7), rs.getDate(8), rs.getString(9),
                    rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13),
                    rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17),
                    rs.getInt(18), rs.getInt(19), rs.getInt(20), rs.getString(21)));


        }

        return members;
    }

    @Override
    public MemberModel get(int id)
    {

        String sql = "SELECT * FROM Member " +
                    "join Grade on Member.grade_id = Grade.grade_id " +
                    "join School on Member.school_id = School.school_id " +
                    "WHERE member_id = " + id +
                    " order by enrollment_date desc";

        SqlRowSet rs = jdbc.queryForRowSet(sql);

        rs.next();
        //  (int id, int webshopId, int quantity, String title, double price)
        MemberModel member =
                new MemberModel(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getDate(7), rs.getDate(8), rs.getString(9),
                        rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13),
                        rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17),
                        rs.getInt(18), rs.getInt(19), rs.getInt(20), rs.getString(21));
        return member;
    }

    @Override
    public List<MemberModel> get()
    {
        List<MemberModel> member = new ArrayList<>();
        String sql = "select * from Member";

        SqlRowSet rs = jdbc.queryForRowSet(sql);

        while (rs.next())
        {
            member.add(new MemberModel(rs.getInt(1), rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getString(5), rs.getString(6),
                    rs.getDate(7), rs.getDate(8), rs.getString(9),
                    rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13),
                    rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17),
                    rs.getInt(18), rs.getInt(19), rs.getInt(20), rs.getString(21)));
        }

        return member;
    }

    @Override
    public void create(MemberModel memberModel)
    {
        Date enrollment_date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");


            String sqlInsertTo = "INSERT INTO Member(first_name, last_name, gender, address, member_phone, enrollment_date, drive_permission, has_allergies, member_details, parent1_name, parent1_phone, parent1_workplace_phone, parent2_name, parent2_phone, parent2_workplace_phone, school_id, grade_id, doctor_id, member_home_phone) " +
                "values('" + memberModel.getFirst_name() + "', '" + memberModel.getLast_name() + "', '" + memberModel.getGender() + "', '" + memberModel.getAddress() + "', '" + memberModel.getMember_home_phone() + "', '" + ft.format(enrollment_date) + "', '" + memberModel.getDrive_permission() + "', '" + memberModel.getHas_allergies() + "', '" + memberModel.getMember_details() + "', '" + memberModel.getParent1_name() + "', '" + memberModel.getParent1_phone() + "', '" + memberModel.getParent1_workplace_phone() + "', '" + memberModel.getParent2_name() + "', '" + memberModel.getParent2_phone() + "', '" + memberModel.getParent2_workplace_phone() + "', '"+ memberModel.getSchool_id() + "', '" + memberModel.getGrade_id() + "', '" + memberModel.getDoctor_id() + "', '" + memberModel.getMember_home_phone() + "')";



        jdbc.update(sqlInsertTo);

    }


    @Override
    public MemberModel getSpecificMemberModel(int id)
    {
        String sqlQuery= "SELECT * FROM member WHERE member_id = " + id + ";";
        SqlRowSet rs = jdbc.queryForRowSet(sqlQuery);

        rs.next();

        MemberModel memberModel = new MemberModel(rs.getInt(1), rs.getString(2), rs.getString(3),
                rs.getString(4), rs.getString(5), rs.getString(6),
                rs.getDate(7), rs.getDate(8), rs.getString(9),
                rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13),
                rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17),
                rs.getInt(18), rs.getInt(19), rs.getInt(20), rs.getString(21));

        return memberModel;
    }


    @Override
    public void delete(int memberid)
    {
        String sqlDelete = "DELETE FROM Member WHERE member_id = " + memberid;
        System.out.println("Før sql");
        jdbc.update(sqlDelete);

        System.out.println(sqlDelete);
        System.out.println(memberid);
        System.out.println("Efter SQL");
    }

}
