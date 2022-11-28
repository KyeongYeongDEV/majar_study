#include <stdio.h>
#include <stdlib.h>

#define TRUE 1
#define FALSE 0
#define MAX_VERTICES 100
#define INF 1000L

typedef struct GraphType {
	int n;	// 정점의 개수
	int weight[MAX_VERTICES][MAX_VERTICES];
} GraphType;

struct Edge{//간선을 나타내는 구조체
    int start,end, weight;
};

int selected[MAX_VERTICES];
int distance[MAX_VERTICES];

// 최소 dist[v] 값을 갖는 정점을 반환
Edge *get_min_vertex(int n, Edge *tmp){
	int v, i;
	for (i = 0; i <n; i++)
		if (!selected[i]) { 
			v = i;
			break;
		}
    // TODO:
    tmp->start = v;

	for (i = 0; i < n; i++)
		if (!selected[i] && (distance[i] < distance[v])){ 
            v = i; 
            //TODO:
            tmp->start = v;
            
        }  // 방문을 하지 않았고, 가중치가 더 작은 것이 있다면 거기로 간다
    //TODO:
	return tmp; 
}

void prim(GraphType* g, int s){
	int i, u, v;
    int maxSize = g->n, totalWeight =0;
    Edge *ver = (Edge*)malloc(sizeof(Edge)* maxSize);
    Edge *tmp = (Edge*)malloc(sizeof(Edge));

	for (u = 0; u < g->n; u++){ //0부터 정점의 개수만큼 돌린다
		distance[u] = INF; 
    }
	distance[s] = 0; 

	for (i = 0; i < g->n; i++) { //정점의 개수만큼 돌림
		tmp = get_min_vertex(g->n, &ver[i]); 
        u = ver[i].start; 
        if( i != 0){
            ver[i-1].end = ver[i].start;
        }

		selected[u] = TRUE; 
		if (distance[u] == INF) return; 

		for (v = 0; v < g->n; v++){ //
			if (g->weight[u][v] != INF){
				if (!selected[v] && g->weight[u][v] < distance[v]){
					distance[v] = g->weight[u][v]; 
                }
            }
        }
	}

    for(int i =0; i < maxSize -1; i++){
        ver[i].weight = g->weight[ver[i].start][ver[i].end];
        distance[i] =g->weight[ver[i].start][ver[i].end];
        printf("정점: %d에서 %d로 이동 / 엣지 : %d\n", ver[i].start,ver[i].end, distance[i]); 
    }

    for(int i = 0 ; i < maxSize; i++){
        for(int j =0; j < maxSize; j++){
            if(i != j)g->weight[i][j] = INF;
        } 
    }

    for(int i =0; i < 6; i++){
        g->weight[ver[i].start][ver[i].end] = ver[i].weight;
        g->weight[ver[i].end][ver[i].start] = ver[i].weight;    
    }

}


int main(void)
{
	GraphType g = { 7, 
	{{ 0, 29, INF, INF, INF, 10, INF },
	{ 29,  0, 16, INF, INF, INF, 15 },
	{ INF, 16, 0, 12, INF, INF, INF },
	{ INF, INF, 12, 0, 22, INF, 18 },
	{ INF, INF, INF, 22, 0, 27, 25 },
	{ 10, INF, INF, INF, 27, 0, INF },
	{ INF, 15, INF, 18, 25, INF, 0 } }
	};
	prim(&g, 0);

    for(int i=0; i < 7; i++){
        for(int j =0; j < 7; j++){
            if(g.weight[i][j] == INF){
                printf("%s ", "INF");    
            }else{
                printf("%d ", g.weight[i][j]);
            }
            
        }
        printf("\n");
    }
	return 0;
}
