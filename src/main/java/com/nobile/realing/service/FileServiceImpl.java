package com.nobile.realing.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nobile.realing.entity.File;
import com.nobile.realing.entity.Profile;
import com.nobile.realing.entity.User;
import com.nobile.realing.exception.custom.EntityNotFoundException;
import com.nobile.realing.repository.FileRepository;
import com.nobile.realing.repository.ProfileRepository;
import com.nobile.realing.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FileServiceImpl implements FileService {
    
    FileRepository fileRepo;
    UserRepository userRepo;
    ProfileRepository profileRepo;

    @Override
    public File getFile(Long id) {
        Optional<File> file= fileRepo.findById(id);
        return fileExists(file,id);
    }

    public List<File> getFilesByProfileId(Long profileId) {
        List<File> files= fileRepo.getByProfileId(profileId);
        return files;
    }

    @Override
    public File saveFile(File file,Long profileId) {
        Optional<Profile> unwrappedProfile= profileRepo.findById(profileId);
        Profile profile= ProfileServiceImpl.profileExists(unwrappedProfile, profileId);
        file.setProfile(profile);
        return fileRepo.save(file);
    }

    @Override
    public File updateFile(Long id,String name)  {
        Optional<File> unwrappedFile= fileRepo.findById(id);
        File file= fileExists(unwrappedFile,id);
        file.setName(name);

        return fileRepo.save(file);
    }

    @Override
    public void deleteFile(Long id) {
        fileRepo.deleteById(id);
    }

    public static File fileExists(Optional<File> file,Long id){
        if(file.isPresent()){
            return file.get();
        }else{
            throw new EntityNotFoundException(id, File.class);
        }
    }
    
}
