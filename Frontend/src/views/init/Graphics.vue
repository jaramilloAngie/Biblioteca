<script>
import { Bar } from 'vue-chartjs'
import { Chart as ChartJS, Title, Tooltip, Legend, BarElement, CategoryScale, LinearScale } from 'chart.js'

ChartJS.register(Title, Tooltip, Legend, BarElement, CategoryScale, LinearScale)

export default {
    name: 'BarChart',
    components: { Bar },
    data() {
        return {
            chartData: {
                labels: ['Enero', 'Febrero', 'Marzo', 'Abril','Mayo','Junio','Julio','Agosto'],
                datasets: [{
                    label: 'Prestamos',
                    data: [10, 20, 30, 25, 21, 7, 67, 12],
                    backgroundColor: [
                        'rgba(255, 206, 86, 0.6)'
                    ],
                    borderColor: 'rgba(0, 0, 0, 0.1)',
                    borderWidth: 1
                }]
            },
            chartOptions: {
                responsive: true
            }
        }
    }
}
</script>
<template>
    <Bar id="my-chart-id" :options="chartOptions" :data="chartData" />
</template>