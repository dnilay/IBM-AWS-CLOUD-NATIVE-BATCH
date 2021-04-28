const express = require('express');
const Joi = require("joi");
const router = express.Router();
const courses = [
  { id: 1, name: 'course1' },  
  { id: 2, name: 'course2' },  
  { id: 3, name: 'course3' },  
];

router.get('/', (req, res) => {
  res.send(courses);
});

router.post('/',(request,response)=>{
  const { error }= validateCourse(request.body);
  if(error)
  {
     return response.status(400).send(error.details[0].message);
  }
  const course = {
    id: courses.length + 1,
    name: request.body.name
  };
  courses.push(course);
  response.send(course);
});

function validateCourse(course) {
  const schema = {
    name: Joi.string().min(3).required()
  };

  return Joi.validate(course, schema);

}
module.exports = router; 
