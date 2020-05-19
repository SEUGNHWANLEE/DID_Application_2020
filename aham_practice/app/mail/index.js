// using Twilio SendGrid's v3 Node.js Library
// https://github.com/sendgrid/sendgrid-nodejs
import * as sgMail from '@sendgrid/mail';
// require('dotenv').config(); //.env 파일 불러오기

var msg = { //default
    to: '',
    from: 'seunghwanly@gmail.com',
    template_id: 'd-64e89c6803564695b2e387708ea5e426',
    substitutionWrappers: ['{{', '}}'],
    dynamicTemplateData: {
        name: '박종하님',
        pin_code: '5678',
        Sender_Name: 'SEUNGHWAN',
        city: "Seoul",
      },
}

export default {
    sendEmail(address,pinCode) {
        // const sgMail = require('@sendgrid/mail');
        sgMail.setApiKey('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');

        msg.to = address;
        msg.dynamicTemplateData.pin_code = pinCode.toString();

        sgMail.send(msg)
            .then(response => {
                console.log('sent!');
            })
            .catch(err => {
                console.log(err);
            });
        }
}