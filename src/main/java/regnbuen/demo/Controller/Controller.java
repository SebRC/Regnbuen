package regnbuen.demo.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import regnbuen.demo.Interfaces.RepositoryInterface;
import regnbuen.demo.Models.DoctorModel;
import regnbuen.demo.Models.MemberModel;
import regnbuen.demo.Models.ParentModel;
import regnbuen.demo.Models.SchoolModel;
import regnbuen.demo.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import regnbuen.demo.ViewFactory;

@org.springframework.stereotype.Controller
public class Controller
{

    @Autowired
    private RepositoryInterface memberRepository = new MemberRepository();

    @Autowired
    private SchoolRepository schoolRepository = new SchoolRepository();

    @Autowired
    private GradeRepository gradeRepository = new GradeRepository();

    @Autowired
    private ParentRepository parentRepository = new ParentRepository();

    @Autowired
    private DoctorRepository doctorRepository = new DoctorRepository();

    @Autowired
    private ViewFactory viewFactory = new ViewFactory();


    /*@RequestMapping("/")
    public String home(Model medlem)
    {
        System.out.printf("hej");
        medlem.addAttribute("index");

        return "/index";
    }*/

    @RequestMapping(value="/opretmedlem",method = RequestMethod.GET)
    public String create (Model model)
    {

        //Den første string referrerer til html
        //Den anden er til member model
        model.addAttribute("schoolList", schoolRepository.getList());
        model.addAttribute("gradeList", gradeRepository.getList());
        model.addAttribute("doctorList", doctorRepository.getList());


        model.addAttribute("doctorCreate", new DoctorModel());
        model.addAttribute("memberCreate", new MemberModel());

        //TODO:  LAV EN MESSAGE DER CONFIRMER OPRET
        return "opretmedlem";
    }

    @RequestMapping(value="/opretmedlem", method = RequestMethod.POST)
    public String create (@ModelAttribute MemberModel medlem)
    {
        memberRepository.create(medlem);
        return "redirect:/opretmedlem";
    }

    /*
    @RequestMapping(value="/opretmedlem", method = RequestMethod.POST)
    public String doctorCreate (@ModelAttribute DoctorModel doctor)
    {
        doctorRepository.doctorCreate(doctor);
        return "redirect:/opretmedlem";
    }
    */

    @RequestMapping("/index")
    public String readForside(Model model)
    {
        model.addAttribute("views", viewFactory.createViewModels());

        return "/index";
    }

    /*gammel forside 17/05.18
    @RequestMapping("/index")
    public String readForside(Model model)
    {
        model.addAttribute("members", memberRepository.getForside());
        return "/index";
    }*/

    @RequestMapping(value="/opretskole", method = RequestMethod.GET)
    public String createSchool (Model school)
    {
        school.addAttribute("school", new SchoolModel());
        return "/opretskole";
    }

    @RequestMapping(value="/opretskole", method = RequestMethod.POST)
    public String createSchool (@ModelAttribute SchoolModel school, BindingResult br)
    {
        if (br.hasErrors())
            System.out.println(br);

        schoolRepository.create(school);
        return "redirect:/opretskole";
    }

    /*@RequestMapping(value="/testCreate",method = RequestMethod.GET)
    public String create (Model model)
    {
        model.addAttribute("model", new MemberModel());
        return "/testCreate";
    }

    @RequestMapping(value="/testCreate",method = RequestMethod.POST)
    public String create (@ModelAttribute MemberModel model)
    {
        memberRepository.create(model);
        return "redirect:/testCreate";
    }*/

    @RequestMapping(value="/delete",method = RequestMethod.GET)
    public String deleteMember(@RequestParam("id") int id, Model model)
    {
        model.addAttribute("memberModel", memberRepository.getSpecificMemberModel(id));

        System.out.println(memberRepository.getSpecificMemberModel(id).getMember_id());
        // memberRepository.delete(memberRepository.getSpecificMemberModel(id));
        return "requestDelete";
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.POST)
    public String deleteMember(@PathVariable int id)
    {
        System.out.println("før slet model");
        memberRepository.delete(id);
        System.out.println("slettet model");

        return "redirect:/index";
    }
}
