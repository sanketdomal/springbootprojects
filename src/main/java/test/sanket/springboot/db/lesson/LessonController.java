package test.sanket.springboot.db.lesson;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import test.sanket.springboot.db.course.Course;
import test.sanket.springboot.db.topic.Topic;

@RestController
public class LessonController {
	
	@Autowired
	LessonService lessonService;

	@RequestMapping("/topics/{topicId}/courses/{id}/lessons")
	public List<Lesson> getAllLessons(@PathVariable String id) {
		return lessonService.getAllLessons(id);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{courseId}/lessons/{id}")
	public Lesson getLesson(@PathVariable String id) {
		return lessonService.getLesson(id);
	}
	
	@RequestMapping(method = RequestMethod.POST,
			value="/topics/{topicId}/courses/{courseId}/lessons")
	public void addLesson(@RequestBody Lesson lesson, @PathVariable String topicId, @PathVariable String courseId) {
		
		lesson.setCourse(new Course(courseId, "", "", topicId) );
		lessonService.addLesson(lesson);
	}
	
	@RequestMapping(method = RequestMethod.PUT,
			value="/topics/{topicId}/courses/{courseId}/lessons/{id}")
	public void updateLesson(@RequestBody Lesson lesson,  @PathVariable String topicId,@PathVariable String courseId) {
		lesson.setCourse(new Course(courseId, "", "", topicId) );
		lessonService.updateLesson(lesson);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,
			value="/topics/{topicId}/courses/{courseId}/lessons/{id}")
	public void deleteLesson(@PathVariable String id) {
		lessonService.deleteLesson(id);
	}
	
	
	
}
