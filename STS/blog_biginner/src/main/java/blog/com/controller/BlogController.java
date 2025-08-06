package blog.com.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import blog.com.model.entity.BlogEntity;
import blog.com.model.entity.UserEntity;
import blog.com.service.BlogService;
import jakarta.servlet.http.HttpSession;

@RequestMapping("/user/blog")
@Controller
public class BlogController {
	@Autowired 
	private BlogService blogService;
	@Autowired 
	private HttpSession session;
	
	@GetMapping("/list")
	public String getBlogListPage(Model model) {
		UserEntity userList = (UserEntity) session.getAttribute("user");
		Long userId = userList.getUserId();
		String userName = userList.getUserName();
		List<BlogEntity>blogList = blogService.findAllBlogPost(userId);
		model.addAttribute("userName", userName);
		model.addAttribute("blogList", blogList);
		return "blog-list.html";
	}

	@GetMapping("/register")
	public String getBlogRegisterPage(Model model) {
		UserEntity userList = (UserEntity) session.getAttribute("user");
		String userName = userList.getUserName();
		model.addAttribute("userName", userName);
		model.addAttribute("registerMessage", "新規記事追加");
		return "blog-register.html";
	}

	@PostMapping("/register/process")
	public String blogRegister(@RequestParam String blogTitle,
			@RequestParam LocalDate registerDate, 
			@RequestParam String category,
			@RequestParam MultipartFile blogImage,
			@RequestParam String blogDetail,Model model) {
		UserEntity userList = (UserEntity) session.getAttribute("user");
		Long userId = userList.getUserId();
		String fileName = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-").format(new Date()) + blogImage.getOriginalFilename();
		try {
//			Files.copy(blogImage.getInputStream(), Path.of("src/main/resources/static/blog-img/" + fileName));
			Files.copy(blogImage.getInputStream(), Path.of("./images/" + fileName));
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(blogService.createBlogPost(blogTitle, registerDate, fileName, blogDetail, category, userId)) {
			return "redirect:/user/blog/list";
		}else {
			model.addAttribute("registerMessage", "既に登録済みです");
			return "blog-register.html";
		}

	}

	@GetMapping("/edit/{blogId}")
	public String getBlogEditPage(@PathVariable Long blogId,Model model) {
		UserEntity userList = (UserEntity) session.getAttribute("user");
		String userName = userList.getUserName();
		model.addAttribute("userName", userName);
		BlogEntity blogList = blogService.getBlogPost(blogId);
		if(blogList == null) {
			return "redirect:/user/blog/list";
		}else {
			model.addAttribute("blogList", blogList);
			model.addAttribute("editMessage", "記事編集");
			return "blog-edit.html";
		}
	}
	
	@PostMapping("/update")
	public String blogUpdate(@RequestParam String blogTitle,
			@RequestParam LocalDate registerDate, 
			@RequestParam String category,
			@RequestParam String blogDetail,
			@RequestParam MultipartFile blogImage,
			@RequestParam Long blogId,Model model) {
		UserEntity userList = (UserEntity) session.getAttribute("user");
		Long userId = userList.getUserId();
		
		String fileName = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-").format(new Date())
				+ blogImage.getOriginalFilename();
		try {
//			Files.copy(blogImage.getInputStream(), Path.of("src/main/resources/static/blog-img/"+fileName));
			Files.copy(blogImage.getInputStream(), Path.of("./images/" + fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(blogService.editBlogPost(blogTitle, registerDate, blogDetail, fileName, category, userId, blogId)) {
			return "redirect:/user/blog/list";
		}else {
			model.addAttribute("registerMessage", "更新に失敗しました");
			return "blog-edit.html";
		}
	}

	@PostMapping("/delete")
	public String blogDelete(@RequestParam Long blogId,Model model) {
		if(blogService.deleteBlog(blogId)) {
			return "redirect:/user/blog/list";
		}else {
			model.addAttribute("DeleteDetailMessage", "記事削除に失敗しました");
			return "blog-delete.html";
		}
	}

	@GetMapping("/logout")
	public String Logout() {
		session.invalidate();
		return "redirect:/user/login";
	}
	
}
