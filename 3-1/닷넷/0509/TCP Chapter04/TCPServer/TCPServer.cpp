#include <winsock2.h>
#include <stdlib.h>
#include <stdio.h>

#define BUFSIZE 512

void ErrorHandling(char *message);

// ���� �Լ� ���� ��� �� ����
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

// ���� �Լ� ���� ���
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

int main(int argc, char* argv[])
{
	WSADATA	wsaData;
	SOCKET hServSock;
	SOCKET hClntSock;
	SOCKADDR_IN servAddr;
	SOCKADDR_IN clntAddr;
	unsigned char *p;
	int szClntAddr;
	char message[] = "Hello World!\n";

	if (argc != 2){
		printf("Usage : %s <port>\n", argv[0]);
		exit(1);
	}

	if (WSAStartup(MAKEWORD(2, 2), &wsaData) != 0) /* Load Winsock 2.2 DLL */
		ErrorHandling("WSAStartup() error!");

	int retval;


	// ���� �ʱ�ȭ
	WSADATA wsa;
	if(WSAStartup(MAKEWORD(2,2), &wsa) != 0)
		return -1;

	// socket()
	SOCKET listen_sock = socket(AF_INET, SOCK_STREAM, 0);
	if(listen_sock == INVALID_SOCKET) err_quit("socket()");	
	
	// bind()
	SOCKADDR_IN serveraddr;
	ZeroMemory(&serveraddr, sizeof(serveraddr));
	serveraddr.sin_family = AF_INET;
	serveraddr.sin_port = htons(9000);
	serveraddr.sin_addr.s_addr = htonl(INADDR_ANY);
	retval = bind(listen_sock, (SOCKADDR *)&serveraddr, sizeof(serveraddr));
	if(retval == SOCKET_ERROR) err_quit("bind()");
	
	// listen()
	retval = listen(listen_sock, SOMAXCONN);
	if(retval == SOCKET_ERROR) err_quit("listen()");

	// ������ ��ſ� ����� ����
	SOCKET client_sock;
	SOCKADDR_IN clientaddr;
	int addrlen;
	char buf[BUFSIZE+1];

	// �߰���



	while(1){
		// accept()
		addrlen = sizeof(clientaddr);
		client_sock = accept(listen_sock, (SOCKADDR *)&clientaddr, &addrlen);
		if(client_sock == INVALID_SOCKET){
			err_display("accept()");
			continue;
		}
		printf("\n[TCP ����] Ŭ���̾�Ʈ ����: IP �ּ�=%s, ��Ʈ ��ȣ=%d\n", 
			inet_ntoa(clientaddr.sin_addr), ntohs(clientaddr.sin_port));

		// Ŭ���̾�Ʈ�� ������ ���
		while(1){ // ���� while
			// ������ �ޱ�
			retval = recv(client_sock, buf, BUFSIZE, 0); // recv == ��ٸ���.// ��� ���� // ������ �� ������ ��ٸ���.
			if(retval == SOCKET_ERROR){
				err_display("recv()");
				break;
			}
			else if(retval == 0)
				break;

			// ���� ������ ���
			buf[retval] = '\0';
			

			printf("[TCP/%s:%d] %s\n", inet_ntoa(clientaddr.sin_addr),
				ntohs(clientaddr.sin_port), buf);

			// ������ ������
			int len = strlen(buf);
			for (int i = 0; i < len; i++){
				if (buf[i] >= 97 & buf[i] <= 122){
					buf[i] -= 32;
				}
			}
			retval = send(client_sock, buf, retval, 0); //
			if(retval == SOCKET_ERROR){
				err_display("send()");
				break;
			}
		}

		// closesocket()
		closesocket(client_sock);
		printf("[TCP ����] Ŭ���̾�Ʈ ����: IP �ּ�=%s, ��Ʈ ��ȣ=%d\n", 
			inet_ntoa(clientaddr.sin_addr), ntohs(clientaddr.sin_port));
	}

	// closesocket()
	closesocket(listen_sock);

	// ���� ����
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

//// ���� �ʱ�ȭ
//WSADATA wsa;
//if(WSAStartup(MAKEWORD(2,2), &wsa) != 0)
//	return -1;

//// socket()
//SOCKET listen_sock = socket(AF_INET, SOCK_STREAM, 0);
//if(listen_sock == INVALID_SOCKET) err_quit("socket()");	
//
//// bind()
//SOCKADDR_IN serveraddr;
//ZeroMemory(&serveraddr, sizeof(serveraddr));
//serveraddr.sin_family = AF_INET;
//serveraddr.sin_port = htons(9000);
//serveraddr.sin_addr.s_addr = htonl(INADDR_ANY);
//retval = bind(listen_sock, (SOCKADDR *)&serveraddr, sizeof(serveraddr));
//if(retval == SOCKET_ERROR) err_quit("bind()");
//
//// listen()
//retval = listen(listen_sock, SOMAXCONN);
//if(retval == SOCKET_ERROR) err_quit("listen()");

//// ������ ��ſ� ����� ����
//SOCKET client_sock;
//SOCKADDR_IN clientaddr;
//int addrlen;
//char buf[BUFSIZE+1];

//// �߰���
//unsigned char *p;

//SOCKADDR_IN servAddr;
//SOCKADDR_IN clntAddr;

//while(1){
//	// accept()
//	addrlen = sizeof(clientaddr);
//	client_sock = accept(listen_sock, (SOCKADDR *)&clientaddr, &addrlen);
//	if(client_sock == INVALID_SOCKET){
//		err_display("accept()");
//		continue;
//	}
//	printf("\n[TCP ����] Ŭ���̾�Ʈ ����: IP �ּ�=%s, ��Ʈ ��ȣ=%d\n", 
//		inet_ntoa(clientaddr.sin_addr), ntohs(clientaddr.sin_port));

//	// Ŭ���̾�Ʈ�� ������ ���
//	while(1){ // ���� while
//		// ������ �ޱ�
//		retval = recv(client_sock, buf, BUFSIZE, 0); // recv == ��ٸ���.// ��� ���� // ������ �� ������ ��ٸ���.
//		if(retval == SOCKET_ERROR){
//			err_display("recv()");
//			break;
//		}
//		else if(retval == 0)
//			break;

//		// ���� ������ ���
//		buf[retval] = '\0';
//		

//		printf("[TCP/%s:%d] %s\n", inet_ntoa(clientaddr.sin_addr),
//			ntohs(clientaddr.sin_port), buf);

//		// ������ ������
//		int len = strlen(buf);
//		for (int i = 0; i < len; i++){
//			if (buf[i] >= 97 & buf[i] <= 122){
//				buf[i] -= 32;
//			}
//		}
//		retval = send(client_sock, buf, retval, 0); //
//		if(retval == SOCKET_ERROR){
//			err_display("send()");
//			break;
//		}
//	}

//	// closesocket()
//	closesocket(client_sock);
//	printf("[TCP ����] Ŭ���̾�Ʈ ����: IP �ּ�=%s, ��Ʈ ��ȣ=%d\n", 
//		inet_ntoa(clientaddr.sin_addr), ntohs(clientaddr.sin_port));
//}

//// closesocket()
//closesocket(listen_sock);

//// ���� ����
//WSACleanup();
//return 0;