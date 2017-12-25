package test.sanket.springboot.db.lesson;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {

	@Autowired
	private LessonRepository lessonRepository;

	public List<Lesson> getAllLessons(String courseId) {

		List<Lesson> topics = new ArrayList<>();
		lessonRepository.findByCourseId(courseId).forEach(topics::add);

		return topics;
	}

	public void addLesson(Lesson lesson) {
		lessonRepository.save(lesson);
	}

	public Lesson getLesson(String lessonId) {
		return lessonRepository.findOne(lessonId);
	}

	public void updateLesson(Lesson lesson) {
		lessonRepository.save(lesson);
	}

	public void deleteLesson(String id) {
		lessonRepository.delete(id);
	}

}
