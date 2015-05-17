package nz.co.jonker.dagger2trial.data.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jonker on 15/05/15.
 */
public class Course implements Parcelable {
    String title;
    String image;

    public Course() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    protected Course(Parcel in) {
        title = in.readString();
        image = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(image);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Course> CREATOR = new Parcelable.Creator<Course>() {
        @Override
        public Course createFromParcel(Parcel in) {
            return new Course(in);
        }

        @Override
        public Course[] newArray(int size) {
            return new Course[size];
        }
    };
}
//{
//        "instructors": [ … ],
//        "subtitle": "Not Your Typical Intro to Web Dev",
//        "key": "ud304",
//        "image": "https://lh6.ggpht.com/KHjK8i_BBLXVYAverR73RvYt06rPk7JnKQWcUIyzMYUnVSPL_zC_asTuM-e69zkibagGRnC5u-bB04nPTQ=s0#w=1278&h=786",
//        "expected_learning": "Front-end Web Developers must have a fundamental understanding of HTML and CSS, which we’ll accomplish in this course by converting digital design mockups into static web pages. To build the web pages you will use HTML, CSS and Bootstrap, the popular Twitter CSS framework.\ \ After completing this course you will be able to build a responsive portfolio site with your own CSS framework. You'll also have the functionality in place to add future projects to your portfolio. Most importantly, you will have an understanding of the DOM and how HTML, CSS, and JavaScript relate to each other.\ \ This course's project is part of our <a href=\"https://www.udacity.com/course/nd001\" target=\"_blank\">Front-End Web Developer</a> Nanodegree.",
//        "featured": true,
//        "teaser_video": {
//        "youtube_url": ""
//        },
//        "title": "Intro to HTML and CSS",
//        "required_knowledge": "You should have ability and skills to download and use a text editor for editing your web pages, we recommend <a href=\"http://www.sublimetext.com/\" target=\"_blank\">Sublime Text</a> or <a href=\"https://atom.io/\" target=\"_blank\">Atom</a>. You can use another text editor if you want, but it should have the ability to highlight code syntax for your own convenience.\ \ You should be able to download and install <a href=\"https://www.google.com/intl/en/chrome/browser/\" target=\"_blank\">Google Chrome</a>, which is the browser we’ll be exploring developer tools with in this course.",
//        "syllabus": "### Lesson 1 - <a href=\"https://udacity.com/course/viewer#!/c-ud304/l-2617868617\">From Design to Code</a>\ \ Diligently employ a code/test/refine strategy as you precisely and deliberately translate initial design documents into static web pages. You'll also investigate the Document Object Model (DOM) and its implications for web development.\ \ ### Lesson 2 - <a href=\"https://udacity.com/course/viewer#!/c-ud304/l-2810388540\">Your Own Framework</a>\ \ Take pride in creating and personalising your own multi-platform, responsive CSS framework for publishing your professional portfolio projects to the web.\ \ ### Lesson 3 - <a href=\"https://udacity.com/course/viewer#!/c-ud304/l-2794148535\">Learning and Using Bootstrap</a>\ \ Strategically investigate an existing professional CSS framework as you use it to build a website using responsive design principles while maintaining code readability.",
//        "new_release": false,
//        "homepage": "https://www.udacity.com/course/intro-to-html-and-css--ud304?utm_medium=referral&utm_campaign=api",
//        "project_name": "Portfolio Mock Up to HTML",
//        "full_course_available": true,
//        "faq": "",
//        "affiliates": [ ],
//        "tracks": [
//        "Web Development"
//        ],
//        "banner_image": "https://lh5.ggpht.com/hsbaPB2ONN_pDAljOlO6i5gWjneQcRnVnn5j4vmYqoqkASy2gcfKnUSogEmFcXAVwZFx1ZL2Pen-toR1zQNS=s0#w=4680&h=968",
//        "short_summary": "Learn how to convert digital design mockups into static web pages and how to build a responsive portfolio site to showcase your work.",
//        "slug": "intro-to-html-and-css--ud304",
//        "starter": false,
//        "level": "beginner",
//        "expected_duration_unit": "weeks",
//        "summary": "HTML and CSS are markup languages and the building blocks that make up the web. This course is called \"Not your Typical Intro...\" because it does not follow the usual pattern of other courses and tutorials that you find on the Internet. Usually HTML and CSS are taught with a focus on language syntax. But knowing syntax alone does not enable you to create a webpage from a design. You need to know where to start and how to approach the task, in other words - you need to learn how to think like a front-end developer. \ \ In this course you will learn how to convert digital design mockups into static web pages. We will teach you how to approach page layout, how to break down a design mockup into page elements, and how to implement that in HTML and CSS.\ \ You will also learn about responsive design techniques, which are increasingly important in a world where mobile devices and TV screens are used more and more often to look for information and entertainment.",
//        "expected_duration": 3
//        },