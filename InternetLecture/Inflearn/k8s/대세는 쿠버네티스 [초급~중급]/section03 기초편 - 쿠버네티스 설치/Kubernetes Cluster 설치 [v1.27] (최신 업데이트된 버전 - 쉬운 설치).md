# 섹션 3. [기초편] 쿠버네티스 설치

## Kubernetes Cluster 설치 [v1.27] (최신 업데이트된 버전 - 쉬운설치)
- host pc에서 VM을 3대 띄워야 한다.
  - 최소 스펙: cpu 6core, memory 16GB
- 설치 가이드
  1. XShell 설치 : 생성될 Master/Worker Node에 접속할 툴 (기존에 쓰고 있는게 있으면 생략가능)
     - 클러스터 모두 설치 후 클러스터에 마스터 노드, 워커 노드에 원격 접속하기 위해 설치 필요
  2. VirtualBox 설치 : VM 및 내부 네트워크 생성 툴
     - Host OS 설치 - Guest OS: Master/Worker VM을 만든다.
  3. Vagrant 설치 및 k8s 설치 스크립트 실행 : 자동으로 VirtualBox를 이용해 VM들을 생성하고, K8S관련 설치 파일들이 실행됨
     - VM 생성
     - 호스트명 
     - 자원 제어
     - VM들간 네트워크 구성
  4. Worker Node 연결 : Worker Node들을 Master에 연결하여 쿠버네티스 클러스터 구축
  5. 설치 확인 : Node와 Pod 상태 조회
     - xshell 접근 -> 구성 잘 됐는지 노드와 파드 상태 확인
  6. 대시보드 접근 : Host OS에서 웹 브라우저를 이용해 클러스터 Dashboard에 접근

- XShell 설치
  - 다운로드 url: https://www.netsarang.com/en/free-for-home-school/
  - Windows 전용으로 개발된 SSH/Telnet 클라이언트
    - 맥북은 기본 터미널이 내장되어 있어 ssh 명령 바로 사용 가능
  - node ip (스크립트 파일 고정시켰다고 함)
    - k8s-master(192.168.56.30:22): ssh -p 22 root@192.168.56.30
    - k8s-node1(192.168.56.31:22): ssh -p 22 root@192.168.56.31
    - k8s-node2(192.168.56.32:22): ssh -p 22 root@192.168.56.32
- VirtualBox 설치
  - 직접 생성하지 않는다.
- Vagrant 설치 및 k8s 설치 스크립트 실행
  - [Vagrant 다운로드](https://developer.hashicorp.com/vagrant/install?product_intent=vagrant)
  - workspace/k8s 폴더 생성 후 이동
    - Vagrant 스크립트 다운로드
      - curl -O https://kubetm.github.io/yamls/k8s-install/Vagrantfile
    - Rocky Linux Repo 세팅
      - curl -O https://raw.githubusercontent.com/k8s-1pro/install/main/ground/k8s-1.27/vagrant-2.4.3/rockylinux-repo.json
      - vagrant box add rockylinux-repo.json
    - Vagrant Disk 설정 Plugin 설치
      - vagrant plugin install vagrant-vbguest vagrant-disksize
    - Vagrant 실행 (5~10분 소요)
      - vagrant up
  - vagrant 명령어 참고
    - vagrant up: VM 생성 및 스크립트 설치 (최초 VM생성 할때만 사용 합니다. 생성 이후 부터 VM 기동/중지는 Virtualbox UI를 사용하는걸 권해 드려요.)
    - vagrant halt: 가상 머신 Shutdown, vm들이 모두 내려간다.
    - vagrant ssh: 가상 머신 접속 (vagrant ssh k8s-master)
    - vagrant destroy: 가상머신 삭제 (vagrant up으로 VM 생성 중 에러가 났을 때 이 명령으로 삭제 합니다.)
  

