var nodemailer = require('nodemailer')

var transporter = nodemailer.createTransport({
  service: 'gmail',
  auth: {
    user: 'feyzullahasillioglu@gmail.com',
    pass: 'FaBeY_123'
  }
})

var mailOptions = {
  from: 'feyzullahasillioglu@gmail.com',
  to: 'fadoahmet233@gmail.com',
  subject: 'Sending Email using Node.js',
  text: 'That was easy!'
}

transporter.sendMail(mailOptions, (err, info) => {
  if (err) throw err
   else {
    console.log('Email sent: ' + info.response)
  }
})