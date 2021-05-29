for f in *; do
	if [ -d "$f" ]; then
		cd "./$f
		cd "./java"
		touch "README.md"
		cd ..
		cd "./c++"
                touch "README.md"
                cd ..
		cd ..
	fi
done
