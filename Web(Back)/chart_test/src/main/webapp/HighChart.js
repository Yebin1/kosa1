// 차드가 들어갈 Div id 입력
Highcharts.chart('container', {
	/* 차트 정의 */
	chart: {
		type: 'column'
	},
	/* 차트 타이틀 */
	title: {
		text: 'EMP T 직종별 급여평균'
	},
	/* 차트 서브타이틀, 링크 이동 가능 */
	subtitle: {
		text: 'Source: <a href="http://en.wikipedia.org/wiki/List_of_cities_proper_by_population">EMP Table</a>'
	},
	/* Y축 컬럼 */
	yAxis: {
		min: 0, // 최소값
		title: {
			text: '급여평균 (millions)' // Y축 타이틀
		}
	},
	/* X축 컬럼 */
	xAxis: {
		type: 'category',
		labels: {
			rotation: -45, // 라벨 기울기
			style: {
				fontSize: '13px', // X축 폰트 사이즈
				fontFamily: 'Verdana, sans-serif' // X축 폰트
			}
		}
	},
	/* 범례 사용 X */
	legend: {
		enabled: false
	},
	/* 데이터에 마우스 오버시 나타나는 상세 출력 형식 */
	tooltip: {
		pointFormat: '급여 평균: <b>{point.y:.1f} millions</b>'
	},

	/* 차트 데이터 */
	series: [{
		name: 'Population',
		/* [[x축컬럼 1, 데이터1], [x축컬럼 2, 데이터2], ... ]*/
		data: [
			['CLERK', 1038],
			['SALESMAN', 1400],
			['PRESIDENT', 5000],
			['Emperor', 500],
			['MANAGER', 2758],
			['ANALYST', 3000]
		],
		/* 차트(막대) 안의 데이터 값 표현 방식*/
		dataLabels: {
			enabled: true, // 차트(막대) 안의 데이터 표기 여부 (true : 표기, false : 미표기)
			rotation: -90, // 차트(막대) 안의 데이터 텍스트 각도
			color: 'BLACK', // 차트(막대) 안의 데이터 텍스트 색상
			align: 'right', // 정렬
			//format: '{point.y:.1f}', // one decimal
			y: 10, // 10 pixels down from the top
			style: {
				fontSize: '7px',
				fontFamily: 'Verdana, sans-serif'
			}
		}
	}]
});
	