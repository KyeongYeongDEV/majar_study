#include <winsock2.h>
#include <stdlib.h>
#include <stdio.h>

#define BUFSIZE 512

void ErrorHandling(char *message);

// 소켓 함수 오류 출력 후 종료
void err_quit(char *msg)
{
	LPVOID lpMsgBuf;
	FormatMessage( 
		FORMAT_MESSAGE_ALLOCATE_BUFFER|
		FORMAT_MESSAGE_FROM_SYSTEM,
		NULL, WSAGetLastError(),
		MAKELANGID(LANG_NEUTRAL, SUBLANG_DEFAULT),
		(LPTSTR)&lpMsgBuf, 0, NULL);
	MessageBox(NULL, (LPCTSTR)lpMsgBuf, msg, MB_ICONERROR);
	LocalFree(lpMsgBuf);
	exit(-1);
}

// 소켓 함수 오류 출력
void err_display(char *msg)
{
	LPVOID lpMsgBuf;
	FormatMessage( 
		FORMAT_MESSAGE_ALLOCATE_BUFFER|
		FORMAT_MESSAGE_FROM_SYSTEM,
		NULL, WSAGetLastError(),
		MAKELANGID(LANG_NEUTRAL, SUBLANG_DEFAULT),
		(LPTSTR)&lpMsgBuf, 0, NULL);
	printf("[%s] %s", msg, (LPCTSTR)lpMsgBuf);
	LocalFree(lpMsgBuf);
}

// 사용자 정의 데이터 수신 함수
int recvn(SOCKET s, char *buf, int len, int flags)
{
	int received;
	char *ptr = buf;
	int left = len;

	while(left > 0){
		received = recv(s, ptr, left, flags);
		if(received == SOCKET_ERROR) 
			return SOCKET_ERROR;
		else if(received == 0) 
			break;
		left -= received;
		ptr += received;
	}

	return (len - left);
}

int main(int argc, char* argv[])
{
	int retval;

	WSADATA wsaData;
	SOCKET hSocket;
	char message[30];
	int strLen;
	SOCKADDR_IN servAddr;

	if (argc != 3){
		printf("Usage : %s <IP> <port>\n", argv[0]);
		exit(1);
	}

	if (WSAStartup(MAKEWORD(2, 2), &wsaData) != 0) /* Load WinhSocket 2.2 DLL */
		ErrorHandling("WSAStartup() error!");

	// 윈속 초기화
	WSADATA wsa;
	if(WSAStartup(MAKEWORD(2,2), &wsa) != 0)
		return -1;

	// socket()
	SOCKET sock = socket(AF_INET, SOCK_STREAM, 0);
	if(sock == INVALID_SOCKET) err_quit("socket()");	
	
	// connect()
	SOCKADDR_IN serveraddr;
	ZeroMemory(&serveraddr, sizeof(serveraddr));
	serveraddr.sin_family = AF_INET;
	serveraddr.sin_port = htons(9000); //PORT NUMBER
	serveraddr.sin_addr.s_addr = inet_addr("127.0.0.1");
	retval = connect(sock, (SOCKADDR *)&serveraddr, sizeof(serveraddr));
	if(retval == SOCKET_ERROR) err_quit("connect()");
		
	// 데이터 통신에 사용할 변수
	char buf[BUFSIZE+1];
	int len;

	// 서버와 데이터 통신
	while(1){
		// 데이터 입력
		ZeroMemory(buf, sizeof(buf)); // 효율 때문에 버퍼를 쓴다.//  입력
		printf("\n[보낼 데이터] ");
		if(fgets(buf, BUFSIZE+1, stdin) == NULL)
			break;

		// '\n' 문자 제거
		len = strlen(buf); 
		if(buf[len-1] == '\n')
			buf[len-1] = '\0';
		if(strlen(buf) == 0)
			break;
		

		// 데이터 보내기
		retval = send(sock, buf, strlen(buf), 0); // 서버가 보내줄 때까지 기다린다.
		if(retval == SOCKET_ERROR){
			err_display("send()");
			break;
		}
		printf("[TCP 클라이언트] %d바이트를 보냈습니다.\n", retval);

		// 데이터 받기
		retval = recvn(sock, buf, retval, 0);
		if(retval == SOCKET_ERROR){
			err_display("recv()");
			break;
		}
		else if(retval == 0)
			break;
		
		// 받은 데이터 출력
		buf[retval] = '\0';
		printf("[TCP 클라이언트] %d바이트를 받았습니다.\n", retval);
		printf("[받은 데이터] %s\n", buf);
	}

	// closesocket()
	closesocket(sock);

	// 윈속 종료
	WSACleanup();
	return 0;
}

void ErrorHandling(char *message)
{
	fputs(message, stderr);
	fputc('\n', stderr);
	exit(1);
}



//int retval;
//
//// 윈속 초기화
//WSADATA wsa;
//if (WSAStartup(MAKEWORD(2, 2), &wsa) != 0)
//return -1;
//
//// socket()
//SOCKET sock = socket(AF_INET, SOCK_STREAM, 0);
//if (sock == INVALID_SOCKET) err_quit("socket()");
//
//// connect()
//SOCKADDR_IN serveraddr;
//ZeroMemory(&serveraddr, sizeof(serveraddr));
//serveraddr.sin_family = AF_INET;
//serveraddr.sin_port = htons(9000); //PORT NUMBER
//serveraddr.sin_addr.s_addr = inet_addr("127.0.0.1");
//retval = connect(sock, (SOCKADDR *)&serveraddr, sizeof(serveraddr));
//if (retval == SOCKET_ERROR) err_quit("connect()");
//
//// 데이터 통신에 사용할 변수
//char buf[BUFSIZE + 1];
//int len;
//
//// 서버와 데이터 통신
//while (1){
//	// 데이터 입력
//	ZeroMemory(buf, sizeof(buf)); // 효율 때문에 버퍼를 쓴다.//  입력
//	printf("\n[보낼 데이터] ");
//	if (fgets(buf, BUFSIZE + 1, stdin) == NULL)
//		break;
//
//	// '\n' 문자 제거
//	len = strlen(buf);
//	if (buf[len - 1] == '\n')
//		buf[len - 1] = '\0';
//	if (strlen(buf) == 0)
//		break;
//
//
//	// 데이터 보내기
//	retval = send(sock, buf, strlen(buf), 0); // 서버가 보내줄 때까지 기다린다.
//	if (retval == SOCKET_ERROR){
//		err_display("send()");
//		break;
//	}
//	printf("[TCP 클라이언트] %d바이트를 보냈습니다.\n", retval);
//
//	// 데이터 받기
//	retval = recvn(sock, buf, retval, 0);
//	if (retval == SOCKET_ERROR){
//		err_display("recv()");
//		break;
//	}
//	else if (retval == 0)
//		break;
//
//	// 받은 데이터 출력
//	buf[retval] = '\0';
//	printf("[TCP 클라이언트] %d바이트를 받았습니다.\n", retval);
//	printf("[받은 데이터] %s\n", buf);
//}
//
//// closesocket()
//closesocket(sock);
//
//// 윈속 종료
//WSACleanup();
//return 0;