import React, {useRef} from "react";
import emailjs from "@emailjs/browser";
import './ContactForm.css'

const ContactForm = () => {

    const form = useRef();
    const phoneNumber = '+380972796855';

    const handleCall = () => {
        window.location.href = `tel:${phoneNumber}`;
    }


    const sendEmail = (e) => {
        e.preventDefault();

        emailjs
            .sendForm(
                "service_choisi_shop",
                "template_t1v2ymv",
                form.current,
                "MpbzkwqGRIih_UOWv"
            )
            .then(
                (result) => {
                    console.log(result.text);
                    console.log("message sent");
                    window.alert("message sent")
                },
                (error) => {
                    console.log(error.text);
                }
            );
    };

    return (

        <div className="body">
            <div className="container">
                <div className="contact-box">
                    <div className="left"></div>
                    <div className="right">
                        <form ref={form} onSubmit={sendEmail}>
                            <h2>You can send email</h2>
                            <input type="text" name="user_name" id="name" className="field" placeholder="Your Name"/>
                            <input type="email" name="user_email" id="email" className="field"
                                   placeholder="Your Email"/>
                            <textarea name="message" id="message" className="field" placeholder="Message"/>
                            <button className="btn" id="btn" type="submit" value="Send">Send</button>
                            <h3 className="offer-title">Or you can</h3>
                        </form>
                        <button onClick={handleCall} className="btn-call">Make a Call</button>
                    </div>
                </div>
            </div>
        </div>
    )
        ;
};

export default ContactForm;
