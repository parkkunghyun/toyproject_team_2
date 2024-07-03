document.addEventListener('DOMContentLoaded', (event) => {
    // JS 코드를 여기에 추가할 수 있습니다.
    // 예를 들어, 로그인 버튼 클릭 시 추가적인 유효성 검사를 할 수 있습니다.
    const loginButton = document.getElementById('log.login');
    loginButton.addEventListener('click', (event) => {
        const email = document.querySelector('input[name="memberEmail"]').value;
        const password = document.querySelector('input[name="memberPW"]').value;
        if (!email || !password) {
            event.preventDefault();
            alert('이메일과 비밀번호를 모두 입력해주세요.');
        }
    });
});
