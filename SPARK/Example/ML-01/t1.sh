if [ "$1" == "1" ]; then
   myClass="EstimatorTransformerParamExample"
elif [ "$1" == "2" ]; then
   myClass="PipelineExample"
elif [ "$1" == "3" ]; then
   myClass="TokenizerExample"
elif [ "$1" == "4" ]; then
   myClass="TfIdfExample"
elif [ "$1" == "5" ]; then
   myClass="IndexToStringExample"
elif [ "$1" == "6" ]; then
   myClass="StringIndexerExample"
elif [ "$1" == "7" ]; then
   myClass="LogisticRegressionWithElasticNetExample"
elif [ "$1" == "8" ]; then
   myClass="LogisticRegressionSummaryExample"
else
   myClass="PipelineExample"
fi

echo $myClass
echo ""

spark-submit \
  --class "org.apache.spark.examples.ml.$myClass" \
  --master local[*] \
  target/scala-2.11/ml-01_2.11-0.1.jar 

