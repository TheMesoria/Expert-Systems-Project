#!/bin/bash
function download()
{
	wget https://ddragon.leagueoflegends.com/cdn/9.24.1/img/champion/${1}.png --directory-prefix=../src/main/resources/images/champions
}

input="../src/main/resources/data/list.txt"
while IFS= read -r line
do
        echo "Downloading $line"  
        download ${line}
done < "$input"

