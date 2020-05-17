// using Twilio SendGrid's v3 Node.js Library
// https://github.com/sendgrid/sendgrid-nodejs
import * as sgMail from '@sendgrid/mail';

var msg = { //default
    to: 'seunghwanly@gmail.com',
    from: 'seunghwanly@gmail.com',
    subject: 'Sending with Twilio SendGrid is Fun',
    text: 'and easy to do anywhere, even with Node.js',
    html: '<strong>and easy to do anywhere, even with Node.js</strong>',
}

export default {
    sendEmail(address) {
        // const sgMail = require('@sendgrid/mail');
        sgMail.setApiKey('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');
        
        msg.to = address;

        console.log('got into index.js!')

        sgMail.send(msg)
            .then(response => {
                console.log('sent!');
            })
            .catch(err => {
                console.log(err);
            });
        console.log('done!');
    }
}