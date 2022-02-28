
# ember build --environment=development

ember build --environment=prototype

mv dist/index.html dist/200.html
surge dist kohlanta-stats.surge.sh
mv dist/200.html dist/index.html