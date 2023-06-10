package view;

import controller.MovieController;
import controller.UserController;
import controller.ReviewController;
import domain.dto.UserDto;

import java.util.Scanner;

public class MovieView {
    private static MovieView view;
    public static MovieView getView() {
        if (view == null) {
            view = new MovieView();
        }
        return view;
    }

    public void mainMenu() {
        // mainMenu..
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("========== O Movie System 0.1v ==========");
            System.out.println("========== 메뉴를 선택 해주세요 ==========");
            System.out.println("1. 로그인");
            System.out.println("2. 회원가입");
            System.out.println("0. 종료");
            System.out.print("입력 : ");

            int menu = Integer.parseInt(sc.nextLine());

            switch(menu) {
                case 1 :
                    // 로그인
                    loginMenu();
                    break;

                case 2 :
                    // 회원가입
                    signUpMode();
                    break;

                case 0 :
                    // 종료
                    System.out.println("O Movie 시스템을 종료 합니다.");
                    return;

                default :
                    System.out.println("잘못된 메뉴를 선택 하셨습니다. 다시 선택 해 주세요.");
                    break;
            }
        } while(true);
    }

    public void adminMenu() {
        // mainMenu..
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("========== ADMIN 모드에 오신걸 환영 합니다. ==========");
            System.out.println("========== 메뉴를 선택 해주세요 ==========");
            System.out.println("1. 회원 리스트 조회하기");
            System.out.println("2. 영화 추가하기");
            System.out.println("0. 로그아웃");
            System.out.print("입력 : ");

            int menu = Integer.parseInt(sc.nextLine());

            switch(menu) {
                case 1 :
                    // 회원리스트 조회.
                    System.out.println("회원 리스트 조회하기");
                    break;
                case 2 :
                    // 영화 추가하기
                    break;
                case 0 :
                    // 종료
                    System.out.println("어드민 시스템을 종료 합니다.");
                    return;

                default :
                    System.out.println("잘못된 메뉴를 선택 하셨습니다. 다시 선택 해 주세요.");
                    break;
            }
        } while(true);
    }

    public void customerMenu() {
        // mainMenu..
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("========== 안녕하세요 movie_hunter 입니다. ==========");
            System.out.println("========== 메뉴를 선택 해주세요 ==========");
            System.out.println("1. 영화 시청");
            System.out.println("2. 리뷰 작성");
            System.out.println("0. 종료");
            System.out.print("입력 : ");

            int menu = Integer.parseInt(sc.nextLine());

            switch(menu) {
                case 1 :
                    // 영화 시청..
                    MovieController.getController().watchMovie();
                    break;
                case 2 :
                    // 리뷰 작성..
                    ReviewController.getController().insertReview();
                    break;
                case 0 :
                    // 종료
                    System.out.println("감사합니다. movie_hunter 였습니다.");
                    return;

                default :
                    System.out.println("잘못된 메뉴를 선택 하셨습니다. 다시 선택 해 주세요.");
                    break;
            }
        } while(true);
    }

    public void loginMenu() {
        // adminMenu..
        Scanner sc = new Scanner(System.in);
        UserController controller = UserController.getController();

        System.out.println("========== (LOGIN MODE)  ==========");

        System.out.println("아이디를 입력 해주세요.");
        String userId = sc.nextLine();

        System.out.println("비밀번호를 입력 해주세요.");
        String userPwd = sc.nextLine();

        controller.login(userId, userPwd);
    }

    public void signUpMode() {
        Scanner sc = new Scanner(System.in);
        UserController controller = UserController.getController();

        System.out.println("========== (SignUp MODE)  ==========");

        System.out.println("아이디를 입력 해주세요.");
        String userId = sc.nextLine();

        System.out.println("Email을 입력 해주세요.");
        String userEmail = sc.nextLine();

        System.out.println("비밀번호를 입력 해주세요.");
        String userPwd = sc.nextLine();

        UserDto userDto = new UserDto();

        userDto.setUserId(userId);
        userDto.setUserEmail(userEmail);
        userDto.setUserPwd(userPwd);

        controller.signUp(userDto);

    }
}
