package com.example.social.media.platform.API.Controller;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/create")
    public ResponseEntity<String> createPost(@RequestBody PostDTO postDTO) {
        postService.createPost(postDTO);
        return ResponseEntity.ok("Post created successfully");
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDTO> getPost(@PathVariable Long postId) {
        Post post = postService.getPostById(postId);
        PostDTO postDTO = // Convert post entity to DTO
        return ResponseEntity.ok(postDTO);
    }
}

