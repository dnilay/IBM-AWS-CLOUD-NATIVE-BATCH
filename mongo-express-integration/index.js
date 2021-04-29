const mongoose = require('mongoose');
const customers = require('./routes/customer');
const express = require('express');
const app = express();
mongoose.connect('mongodb+srv://user1:61FEW6YWQT8s05WG@cluster0.galid.mongodb.net/vidly?retryWrites=true&w=majority',{ useUnifiedTopology: true, useNewUrlParser: true })
    .then(() => console.log('Connected to MongoDB...'))
    .catch(err => console.error('Could not connect to MongoDB...'));

app.use(express.json());
app.use('/api/customers', customers);

const port = 3000;
app.listen(port, () => console.log(`Listening on port ${port}...`));
